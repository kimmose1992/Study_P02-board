$(document).ready(function(){
    var scroll_distance = 100;
    var transparent = true;
    document.addEventListener("scroll", function(){
        if($(document).scrollTop() > scroll_distance ) {
            if(transparent) {
                transparent = false;
                $('#header_wrap').addClass('changeColor');
                $('header nav > ul > li > a').css('color','#000');
                $('#menubtn_box span').css('background-color','#000');
            }
        } else {
            if( !transparent ) {
                transparent = true;
                $('#header_wrap').removeClass('changeColor');
                $('header nav > ul > li > a').css('color','##313131');
                $('#menubtn_box span').css('background-color','##313131');
            }
        }
    });

    window.addEventListener("scroll", function(){
        if($(document).scrollTop() > scroll_distance ) {
            if(transparent) {
                transparent = false;
                $('#header_wrap').addClass('changeColor');
                $('header nav > ul > li > a').css('color','#000');
                $('#menubtn_box span').css('background-color','#000');
                $('#logo img').prop('src','/images/slyouth/logo_black.png');
            }
        } else {
            if( !transparent ) {
                transparent = true;
                $('#header_wrap').removeClass('changeColor');
                $('header nav > ul > li > a').css('color','#fff');
                $('#menubtn_box span').css('background-color','#fff');
                $('#logo img').prop('src','/images/slyouth/logo.png');
            }
        }
    });

    $("#menubtn_box_touch").click(function(){
        $("#menu_box").css({"right":"0","display":"block"});
        $("#wrap").css({"overflow":"hidden","position":"fixed"});
    });

    $("#menubtn_box_position").click(function(){
        $("#menu_box").css({"display":"none","right":"-315px"});
        $("#wrap").css({"overflow":"none","position":"static"});
    });
    
    var meueclick1=0;
	var meueclickCheck1=0;

    $(".meueclick1").click(function(){
        meueclick1++;
        meueclickCheck1 = meueclick1%2;

        if(meueclickCheck1 == 1){
            $(".menublock1").css("display","block");
        }else{
            $(".menublock1").css("display","none");
        }
    });

    var meueclick2=0;
	var meueclickCheck2=0;

    $(".meueclick2").click(function(){
        meueclick2++;
        meueclickCheck2 = meueclick2%2;

        if(meueclickCheck2 == 1){
            $(".menublock2").css("display","block");
        }else{
            $(".menublock2").css("display","none");
        }
    });

    var meueclick3=0;
	var meueclickCheck3=0;

    $(".meueclick3").click(function(){
        meueclick3++;
        meueclickCheck3 = meueclick3%2;

        if(meueclickCheck3 == 1){
            $(".menublock3").css("display","block");
        }else{
            $(".menublock3").css("display","none");
        }
    });

    var meueclick4=0;
	var meueclickCheck4=0;

    $(".meueclick4").click(function(){
        meueclick4++;
        meueclickCheck4 = meueclick4%2;

        if(meueclickCheck4 == 1){
            $(".menublock4").css("display","block");
        }else{
            $(".menublock4").css("display","none");
        }
    });

    var meueclick5=0;
	var meueclickCheck5=0;

    $(".meueclick5").click(function(){
        meueclick5++;
        meueclickCheck5 = meueclick5%2;

        if(meueclickCheck5 == 1){
            $(".menublock5").css("display","block");
        }else{
            $(".menublock5").css("display","none");
        }
    });

    var meueclick6=0;
	var meueclickCheck6=0;

    $(".meueclick6").click(function(){
        meueclick6++;
        meueclickCheck6 = meueclick6%2;

        if(meueclickCheck6 == 1){
            $(".menublock6").css("display","block");
        }else{
            $(".menublock6").css("display","none");
        }
    });

    var meueclick7=0;
	var meueclickCheck7=0;

    $(".meueclick7").click(function(){
        meueclick7++;
        meueclickCheck7 = meueclick7%2;

        if(meueclickCheck7 == 1){
            $(".menublock7").css("display","block");
        }else{
            $(".menublock7").css("display","none");
        }
    });

    var meueclick8=0;
	var meueclickCheck8=0;

    $(".meueclick8").click(function(){
        meueclick8++;
        meueclickCheck8 = meueclick8%2;

        if(meueclickCheck8 == 1){
            $(".menublock8").css("display","block");
        }else{
            $(".menublock8").css("display","none");
        }
    });

    var meueclick9=0;
	var meueclickCheck9=0;

    $(".meueclick9").click(function(){
        meueclick9++;
        meueclickCheck9 = meueclick9%2;

        if(meueclickCheck9 == 1){
            $(".menublock9").css("display","block");
        }else{
            $(".menublock9").css("display","none");
        }
    });

    

    var meueclick10=0;
	var meueclickCheck10=0;

    $(".meueclick10").click(function(){
        meueclick10++;
        meueclickCheck10 = meueclick10%2;

        if(meueclickCheck10 == 1){
            $(".menublock10").css("display","block");
        }else{
            $(".menublock10").css("display","none");
        }
    });
    
    var meueclick11=0;
	var meueclickCheck11=0;

    $(".meueclick11").click(function(){
        meueclick11++;
        meueclickCheck11 = meueclick11%2;

        if(meueclickCheck11 == 1){
            $(".menublock11").css("display","block");
        }else{
            $(".menublock11").css("display","none");
        }
    });
    
    var meueclick12=0;
	var meueclickCheck12=0;

    $(".meueclick12").click(function(){
        meueclick12++;
        meueclickCheck12 = meueclick12%2;

        if(meueclickCheck12 == 1){
            $(".menublock12").css("display","block");
        }else{
            $(".menublock12").css("display","none");
        }
    });
});