/**
 * JQuery
 */
jQuery.fn.serializeObject = function() {
	var obj = null;
	try {
		if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
			var arr = this.serializeArray();
			if (arr) {
				obj = {};
				jQuery.each(arr, function() {
					obj[this.name] = this.value;
        		});
          	}
		}
	} catch (e) {
		alert(e.message);
	} finally {
	}
   
	return obj;
};

/**
 * Global
 */
var gCallback;

/**
 * CSRF
 */
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
var parameter = $("meta[name='_csrf_parameter']").attr("content");

/**
 * Common JS 
 */
var com = {};

/**
 * Ajax Post 메소드
 * @param 	url, param, callback, isAsync
 * @return 	data
 * @example	com.loadAjaxPost("/sd/selectCodeList", params, callback, false)
 */
com.loadAjaxPost = function(url, params, callback, isAsync) {

	// Async 옵션을 안줄경우 기본값 true
	if (isAsync === undefined) {
		isAsync = true;
	}
	
	$.ajax({
		type  : 'POST'
	  , url   : url
	  , data  : params
	  , async : isAsync
	  , beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
        }
	  , success : function(res) {
			callback(res);
		}
	  , error : function(xhr, status, error) {
			callback(error);
		}
	});
};

/**
 * 화면 이동 Submit Post 메소드
 * @param 	url, data
 * @return 	data
 * @example	com.movePagePost("/sd/selectCodeList", params)
 */
com.movePagePost = function(url, params) {
    
	// url 검증
	if (url == null || url == undefined) {
		return;
	}
	
	// params 검증
	if (params == null || params == undefined) {
		return;
	}	

	// form 생성	
    var form = document.createElement('form');
    
	form.setAttribute('method',	"post");
    form.setAttribute('action', url);
	
	// csrf 설정
	params[parameter] = token;
	
	// form 객체 hidden 값 설정	
	var hiddenField;
	
    for (var key in params) {
		if (params.hasOwnProperty(key)) {
			hiddenField = document.createElement('input');
			hiddenField.setAttribute('type',  'hidden');
          	hiddenField.setAttribute('name',  key);
          	hiddenField.setAttribute('value', params[key]);
         
         	form.appendChild(hiddenField);
       }
    }

	document.body.appendChild(form);
	form.submit();
};

/**
 * 콤보박스 기본 구성 메소드
 * @param 	codeParams (codeKey, comboId, comboType)
 * @return 	code, codeLabel
 * @example	var codeParams = [];
			codeParams.push({"codeKey":"SD0001", "comboId":"selTskDivCd", "comboType":"A"});
			com.makeCombo(codeParams);
 */
com.makeCombo = function(codeParams, callback, isAsync) {
	
	// 콜백 전역 설정
	gCallback = callback;
	
	// 콤보 변수 설정
	var codeKeyArr = [];
	var comboIdArr = [];
	var comboTypeArr = [];
	
	for(var i=0; i<codeParams.length; i++) {
		codeKeyArr.push(codeParams[i].codeKey);
		comboIdArr.push(codeParams[i].comboId);
		comboTypeArr.push(codeParams[i].comboType);
	}
	
	var params = {};
	params.codeKeyArr = codeKeyArr;
	params.comboIdArr = comboIdArr;
	params.comboTypeArr = comboTypeArr;
	
	com.loadAjaxPost("/cm/makeCombo", params, com.viewCombo, isAsync);
};

/**
 * 콤보박스 참조 구성 메소드
 * @param 	codeParams (codeKey, comboId, codeRefKey, codeRefVl, comboType)
 * @return 	code, codeLabel
 * @example	var codeParams = [];
			codeParams.push({"codeKey":"SD0001", "comboId":"selTskDivCd", "codeRefKey":"PRN_CD_GRP_ID", "codeRefVl":"PRN", "comboType":"A"});
			com.makeRefCombo(codeParams, callback);
 */
com.makeRefCombo = function(codeParams, callback, isAsync) {
	
	// 콜백 전역 설정
	gCallback = callback;
	
	// 참조 콤보 호출
	com.loadAjaxPost("/cm/makeCombo", codeParams[0], com.viewCombo, isAsync);
};

/**
 * 콤보박스 커스텀 구성 메소드
 * @param 	codeParams (codeKey, comboId, comboType, codeType)
 * @return 	code, codeLabel
 * @example	var codeParams = [];
			codeParams.push({"codeKey":"TRUCKER", comboId":"selTskDivCd", "comboType":"A", "codeType":"0"});
			com.makeCustomCombo(codeParams, callback);
 */
com.makeCustomCombo = function(codeParams, callback, isAsync) {
	
	// 콜백 전역 설정
	gCallback = callback;
	
	// 콤보 변수 설정
	var codeKeyArr = [];
	var comboIdArr = [];
	var comboTypeArr = [];
	var codeTypeArr = [];
	
	for(var i=0; i<codeParams.length; i++) {
		codeKeyArr.push(codeParams[i].codeKey);
		comboIdArr.push(codeParams[i].comboId);
		comboTypeArr.push(codeParams[i].comboType);
		codeTypeArr.push(codeParams[i].codeType)
	}
	
	var params = {};
	params.codeKeyArr = codeKeyArr;
	params.comboIdArr = comboIdArr;
	params.comboTypeArr = comboTypeArr;
	params.codeTypeArr = codeTypeArr;
	
	com.loadAjaxPost("/cm/makeCustomCombo", params, com.viewCombo, isAsync);
};

/**
 * 콤보박스 화면 설정
 * @param 	codeParams (codeKey, comboId, comboType, codeType)
 * @return 	code, codeLabel
 * @example	var codeParams = [];
			codeParams.push({"codeKey":"TRUCKER", comboId":"selTskDivCd", "comboType":"A", "codeType":"0"});
			com.makeCustomCombo(codeParams, callback);
 */
com.viewCombo = function(res) {
	var comboMap = res.comboMap;

	var comboKey;	// 콤보 키 배열 (comboId, comboType)
	var comboId;	// 콤보 설정 객체
	var comboData;	// 콤보 데이터
	
	for(var key in comboMap) {
		comboKey = key.split("|");
		comboId = $("#" + comboKey[0]);
		comboData = comboMap[key];

		// 콤보박스 초기화
		comboId.empty();

		if (comboKey[1] == "A") {
			comboId.append("<option value=''>전체</option>");
		}
		else if (comboKey[1] == "S") {
			comboId.append("<option value=''>선택</option>");
		}
		
		for(i=0; i<comboData.length; i++) {
			comboId.append("<option value='" + comboData[i].code + "'>" + comboData[i].codeLabel + "</option>");
		}
	}
	
	// 콤보 콜백
	if (!(gCallback == null || gCallback == undefined || gCallback == '')) {
		gCallback();	
	}
}
		
/**
 * 썸머노트 설정 메소드
 * @param 	N/A
 * @return 	N/A
 * @example	com.summernoteInit();
 */
com.summernoteInit = function() {
	
	var fontNames = ['맑은 고딕', '돋움', '궁서', '굴림', '굴림체', '궁서체', '나눔 고딕', '바탕', '바탕체', '새굴림', 'HY견고딕', 'HY견명조', 'HY궁서B', 'HY그래픽M', 'HY목각파임B', 'HY신명조', 'HY얕은샘물M', 'HY엽서L', 'HY엽서M', 'HY중고딕', 'HY헤드라인M', '휴먼매직체', '휴먼모음T', '휴먼아미체', '휴먼편지체', '휴먼옛체'];
	var fontSizes = ['8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72'];
	
	var toolbar = [
	    // 글꼴 설정
	    ['fontname', ['fontname']]
	    // 글자 크기 설정
	  , ['fontsize', ['fontsize']]
	    // 굵기, 기울임꼴, 밑줄, 취소선, 서식지우기
	  , ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']]
	    // 글자색
	  , ['color', ['forecolor', 'color']]
	    // 표만들기
	  , ['table', ['table']]
	    // 글머리 기호, 번호매기기, 문단정렬
	  , ['para', ['ul', 'ol', 'paragraph']]
	    // 줄간격
	  , ['height', ['height']]
	    // 그림첨부, 링크만들기, 동영상첨부
	  , ['insert',['picture','link','video']]
	    // 코드보기, 도움말
	  , ['view', ['codeview', 'help']]
	];

	var settings = {
		placeholder: '내용을 입력하세요.'	// placeholder 설정
	  , height: 400
	  , minHeight: null
	  , maxHeight: null
      , focus: true
      , lang: 'ko-KR'
      , toolbar: toolbar
	  , fontNames: fontNames
	  , fontSizes: fontSizes
      , callbacks : {
			onImageUpload : function(files, editor, welEditable) {
            	for(var i=(files.length - 1); i >= 0; i--) {
            		com.uploadSummernoteImageFile(files[i], this);
				}
			}
		}
	};
		
	$('#summernote').summernote(settings);
	$('#summernote').summernote('fontName', '맑은 고딕');
	$('#summernote').summernote('fontSize', 14);
};

/**
 * 썸머노트 이미지 업로드 메소드
 * @param 	File
 * @return 	Image URL
 */
com.uploadSummernoteImageFile = function(file, el) {
	
	var params = new FormData();
	params.append("uploadFile", file);
	params.append("tmpFileId", $("#tmpFileId").val());
	params.append("refNo", $("#refNo").val());
	params.append("refDivCd", $("#refDivCd").val());
	params.append("refTbKey", $("#refTbKey").val());
	
	$.ajax({
		type : 'POST'
	  , url : '/cm/uploadSummernoteImageFile'
	  , data : params
	  ,	enctype : 'multipart/form-data'
      , processData : false
	  , contentType : false
	  , beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
        }
	  , success : function(data) {
			$(el).summernote('editor.insertImage', data.fileUrl);
		}
	  , error : function(xhr, status, error) {
			callback(error);
		}
	});
};

/**
 * 파일 업로드 메소드
 * @param  	url, param, callback
 * @return 	data
 * @example	com.fileUploadAjaxPost("/um/uploadExcelTemplate", params, callback)
 */
com.fileUploadAjaxPost = function(url, params, callback) {

	$.ajax({
		type : 'POST'
      , url  : url
      , data : params
      , enctype : 'multipart/form-data'
      , processData: false
      , contentType: false
      , beforeSend : function(xhr) {
        	xhr.setRequestHeader(header, token);
        }
      , success : function(res) {
         	callback(res);
        }
      , error : function(xhr, status, error) {
         	callback(error);
      	}
   });
};

/**
 * 페이징 처리 이벤트
 * - 페이지 번호 클릭 : 선택한 페이지 번호로 이동한다.
 * - 페이지 목록 변경 : 선택한 값의 단위로 목록을 표시한다.
 */
com.procPaging = function(url, pageNo) {
	var pagingPrams = $("#searchForm").serializeObject();
	pagingPrams.pageNo = pageNo;
	
	com.movePagePost(url, pagingPrams);
};

// ##################################################
// ## 파일업로드 
// ##################################################
/**
 * 파일 업로드 메소드
 * - 파일 유효성 체크
 * - 파일 업로드 정보 화면 설정 > fileUploadInfo() 메소드 호출
 */
com.fileUpload = function(files) {
	
	if (files && files[0]) {
    	var fileNm = files[0].name;
    	var fileSize = parseInt(files[0].size);
    	var fileMaxSize = parseInt(3 * 1024 * 1204);
    	
    	// 파일업로드 용량체크
    	if (fileSize > fileMaxSize) {
    		alert("3MB 이상의 파일은 첨부할 수 없습니다.");
    		$("#upload").val("");
    		return;
    	}
    	
		// 파일업로드 정보 화면 설정 (파일명, 업로드용량, 버튼)
		com.fileUploadInfo(fileNm, fileSize);
    } else {
		alert("파일이 존재하지 않습니다.");
		$("#upload").val("");
		return;
	}
};

/**
 * 파일 업로드 정보 화면 설정 메소드
 * - 파일 업로드 정보 화면 표시 (파일명, 파일용량, 파일버튼)
 */
com.fileUploadInfo = function(fileNm, fileSize) {
	
	// 파일업로드 정보 화면 출력 (파일명, 업로드용량)
	$("#txtFileNm").val(fileNm);
	$("#txtfileSize").text(parseFloat(fileSize / 1024 / 1024).toFixed(2));
	
	// 파일삭제 버튼 활성화
	$("#fileSelBtn").addClass("d-none");
	$("#fileCncBtn").removeClass("d-none");
}

/**
 * 파일 업로드 취소 메소드
 * - 파일 초기화
 * - 화면에 표시된 파일 업로드 정보 초기화 (파일명, 파일용량, 파일버튼)
 */
com.fileUploadCnc = function() {
	
	// 파일초기화
	$("#upload").val("");
	
	// 파일업로드 정보 초기화
	$("#txtFileNm").val("");
	$("#txtfileSize").text("0.0");
	
	// 파일선택 버튼 활성화
	$("#fileSelBtn").removeClass("d-none");
	$("#fileCncBtn").addClass("d-none");
};

// ##################################################
// ## 유효성 체크 
// ##################################################
/**
 * Empty 체크 메소드
 * @param 	objId, emptyMsg
 * @return 	isEmpty
 * @example	com.vd_isEmpty("summernote")
 */
com.isEmpty = function(objId, emptyMsg) {
	
	if (!(objId == null || objId == '' || objId == undefined)) {
		var trgtObj = $("#" + objId);
		var nodeName = trgtObj[0].nodeName;
		var checkVal = null;
		
		if (nodeName == "INPUT" || nodeName == "SELECT" || nodeName == "TEXTAREA") {
			
			// 썸머노트 에디터는 값을 치환해서 가져옴
			if (objId == 'summernote') {
				checkVal = $(trgtObj.summernote("code").replace(/&nbsp;|<br>/g, ' ')).text().trim();
			} else {
				checkVal = trgtObj.val();
			}
		}
		else {
			// TODO
		}
		
		if (checkVal == null || checkVal == '' || checkVal == undefined) {
			alert(emptyMsg);
			return false;
		}
	} else {
		return false;
	}
	
	return true;
};