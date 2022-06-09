/*
* Kakao map API
*/

var overlayOn = false, // 지도 위에 로드뷰 오버레이가 추가된 상태를 가지고 있을 변수
    container = document.getElementById('container'), // 지도와 로드뷰를 감싸고 있는 div 입니다
    mapWrapper = document.getElementById('mapWrapper'), // 지도를 감싸고 있는 div 입니다
    mapContainer = document.getElementById('map'), // 지도를 표시할 div 입니다 
    rvContainer = document.getElementById('roadview'); //로드뷰를 표시할 div 입니다

var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(37.664001, 126.765369), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };


// 지도를 표시할 div와 지도 옵션으로 지도를 생성
var map = new kakao.maps.Map(mapContainer, mapOption);

// 로드뷰 객체를 생성합니다.
var rv = new kakao.maps.Roadview(rvContainer);

// 좌표로부터 로드뷰 파노라마 ID를 가져올 로드뷰 클라이언트 객체를 생성합니다.
var rvClient = new kakao.maps.RoadviewClient();

// 로드뷰에 좌표가 바뀌었을 때 발생하는 이벤트를 등록합니다.
kakao.maps.event.addListener(rv, 'position_changed', function() {

    // 현재 로드뷰의 위치 좌표를 얻어옵니다.
    var rvPosition = rv.getPosition();

    // 지도의 중심을 현재 로드뷰의 위치로 설정합니다.
    map.setCenter(rvPosition);

    // 지도 위에 로드뷰 도로 오버레이가 추가된 상태이면
    if (overlayOn) {
        // 마커의 위치를 현재 로드뷰의 위치로 설정합니다.
        roadMarker.setPosition(rvPosition);
    }
});

// 지도타입 컨트롤의 지도 또는 스카이뷰 버튼을 클릭하면 호출되어 지도타입을 바꾸는 함수입니다.
function setMapType(maptype) {
    var roadmapControl = document.getElementById('btnRoadmap');
    var skyviewControl = document.getElementById('btnSkyview');
    if (maptype == 'roadmap') {
        map.setMapTypeId(kakao.maps.MapTypeId.ROADMAP);
        roadmapControl.className = 'selected_btn';
        skyviewControl.className = 'btn';
    } else {
        map.setMapTypeId(kakao.maps.MapTypeId.HYBRID);
        skyviewControl.className = 'selected_btn';
        roadmapControl.className = 'btn';
    }
}

// 지도 확대, 축소 컨트롤에서 확대 버튼을 누르면 호출되어 지도를 확대하는 함수입니다.
function zoomIn() {
    map.setLevel(map.getLevel() - 1);
}

// 지도 확대, 축소 컨트롤에서 축소 버튼을 누르면 호출되어 지도를 확대하는 함수입니다.
function zoomOut() {
    map.setLevel(map.getLevel() + 1);
}

// 마커가 표시될 위치입니다.
var markerPosition = new kakao.maps.LatLng(37.664001, 126.765369);

// 마커를 생성합니다.
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다.
marker.setMap(map);

// 로드뷰 오버레이가 추가되면 생성되는 마커 이미지 입니다.
var roadMarkImage = new kakao.maps.MarkerImage(
    'https://t1.daumcdn.net/localimg/localimages/07/2018/pc/roadview_minimap_wk_2018.png',
    new kakao.maps.Size(26, 46), {
        // 스프라이트 이미지를 사용합니다.
        // 스프라이트 이미지 전체의 크기를 지정하고
        spriteSize: new kakao.maps.Size(1666, 168),
        // 사용하고 싶은 영역의 좌상단 좌표를 입력합니다.
        // background-position으로 지정하는 값이며 부호는 반대입니다.
        spriteOrigin: new kakao.maps.Point(705, 114),
        offset: new kakao.maps.Point(13, 46)
    }
);

// 드래그가 가능한 로드뷰 마커를 생성합니다.
var roadMarker = new kakao.maps.Marker({
    image: roadMarkImage,
    draggable: true
});

// 마커에 dragend 이벤트를 등록합니다.
kakao.maps.event.addListener(roadMarker, 'dragend', function(mouseEvent) {

    // 현재 마커가 놓인 자리의 좌표입니다.
    var position = roadMarker.getPosition();

    // 마커가 놓인 위치를 기준으로 로드뷰를 설정합니다.
    toggleRoadview(position);
});

// 지도에 클릭 이벤트를 등록합니다.
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {

    // 지도 위에 로드뷰 도로 오버레이가 추가된 상태가 아니면 클릭이벤트를 무시합니다.
    if (!overlayOn) {
        return;
    }

    // 클릭한 위치의 좌표입니다.
    var position = mouseEvent.latLng;

    // 마커를 클릭한 위치로 옮깁니다.
    roadMarker.setPosition(position);

    // 클릭한 위치를 기준으로 로드뷰를 설정합니다.
    toggleRoadview(position);
});

// 전달받은 좌표에 가까운 로드뷰의 파노라마 ID를 추출하여 로드뷰를 설정하는 함수입니다.
function toggleRoadview(position) {
    rvClient.getNearestPanoId(position, 50, function(panoId) {
        // 파노라마 ID가 null 이면 로드뷰를 숨깁니다.
        if (panoId === null) {
            toggleMapWrapper(true, position);
        } else {
            toggleMapWrapper(false, position);

            // panold로 로드뷰를 설정합니다.
            rv.setPanoId(panoId, position);
        }
    });
}

// 지도를 감싸고 있는 div의 크기를 조정하는 함수입니다.
function toggleMapWrapper(active, position) {
    if (active) {

        // 지도를 감싸고 있는 div의 너비가 100%가 되도록 class를 변경합니다.
        container.className = '';

        // 지도의 크기가 변경되었기 때문에 relayout 함수를 호출합니다.
        map.relayout();

        // 지도의 너비가 변경될 때 지도중심을 입력받은 위치로 설정합니다.
        map.setCenter(position);
    } else {

        // 지도만 보여지고 있는 상태이면 지도의 너비가 50% 되도록 class를 변경하여 로드뷰가 함께 표시되게 합니다.
        if (container.className.indexOf('view_roadview') === -1) {
            container.className = 'view_roadview';

            // 지도의 크기가 변경되었기 때문에 relayout 함수를 호출합니다.
            map.relayout();

            // 지도의 너비가 변경될 때 지도중심을 입력받은 위치로 설정합니다.
            map.setCenter(position);
        }
    }
}

// 지도 위의 로드뷰 도로 오버레이를 추가, 제거하는 함수입니다.
function toggleOverlay(active) {
    if (active) {
        overlayOn = true;

        // 지도 위에 로드뷰 도로 오버레이를 추가합니다.
        map.addOverlayMapTypeId(kakao.maps.MapTypeId.ROADVIEW);

        // 지도 위에 마커를 표시합니다.
        roadMarker.setMap(map);

        // 마커의 위치를 지도 중심으로 설정합니다.
        roadMarker.setPosition(map.getCenter());

    } else {
        overlayOn = false;

        // 지도 위의 로드뷰 도로 오버레이를 제거합니다.
        map.removeOverlayMapTypeId(kakao.maps.MapTypeId.ROADVIEW);

        // 지도 위의 마커를 제거합니다.
        roadMarker.setMap(null);
    }
}

// 지도 위의 로드뷰 버튼을 눌렀을 때 호출되는 함수입니다.
function setRoadviewRoad() {
    var control = document.getElementById('roadviewControl');

    // 버튼이 눌린 상태가 아니면
    if (control.className.indexOf('active') === -1) {
        control.className = 'active';

        // 로드뷰 도로 오버레이가 보이게 합니다.
        toggleOverlay(true);
    } else {
        control.className = '';

        // 로드뷰 도로 오버레이를 제거합니다.
        toggleOverlay(false);
    }
}

// 지도 위의 전체화면 버튼을 눌렀을 때 호출되는 함수입니다.
function fullScreenMode(){
	var docV = document.getElementById('container');
	var control = document.getElementById('fullScreenControl');	
	
	    // 버튼이 눌린 상태가 아니면
    if (!document.fullscreenElement && !document.mozFullScreenElement && !document.webkitFullscreenElement) {
        control.className = 'active';
		
	    if (docV.requestFullscreen) {
	        docV.requestFullscreen();
	    } else if (docV.webkitRequestFullScreen) {
	        docV.webkitRequestFullScreen(); // Chrome, Safari(webkit), Edge
	    } else if (docV.mozRequestFullScreen) {
	        docV.mozRequestFullScreen(); // Firefox
	    } else if (map.msRequestFullscreen) {
	        docV.msRequestFullscreen(); // IE
	    }
		
	}else{
		
		control.className = '';
		
		if (document.exitFullscreen){
	        document.exitFullscreen();
		}else if(document.cancelFullScreen){
			document.cancelFullScreen();
		}else if(document.webkitCancelFullScreen){
			document.webkitCancelFullScreen();
		}else if(document.mozCancelFullScreen){
			document.mozCancelFullScreen();
		}else if(document.msExitFullscreen){
			document.msExitFullscreen();
		}
		
	}
}


// 로드뷰에서 X버튼을 눌렀을 때 로드뷰를 지도 뒤로 숨기는 함수입니다.
// 로드뷰를 확인하고 나면 다시 승리교회를 중심으로 합니다.
// 또 다른 방법은 확인 한 로드뷰를 중심으로 map이 이동합니다.
function closeRoadview() {
    var position = marker.getPosition();

    roadMarker.setPosition(position);

    toggleMapWrapper(true, position);
}
