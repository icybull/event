function contentReg(){
    if(confirm("댓글을 등록하시겠습니까?")){
        let params = $('#frm').serialize();
        $.ajax({
            url :"/join/regContent",
            data : params,
            datatype : 'text',
            type : "POST",
            success : function(result){
                alert("댓글 등록이 완료되었습니다.");
                location.reload();
            }
        });
    }
}

// 페이지네이션 onClick
function pageLoad(page){
    $('#page').val(page);
    let params = $('#frm2').serialize();
    $.ajax({
        url :"/experienceForm.do",
        data : params,
        datatype : 'text',
        type : "GET",
        success : function(result){
            let html = jQuery('<div>').html(result);
            let contents = html.find("div#contentTable").html();
            $('#contentTable').html(contents);
        }
    });
}

function delContent(user_Seq){
    if(confirm("삭제 하시겠습니까?")){
        $.ajax({
            url :"/delContent?user_Seq=" + user_Seq,
            datatype : 'text',
            type : "POST",
            success : function(result){
                location.reload();
            }
        });
    }
}


function myContent() {
    $('#page').val(0);
    if($('#myContent').val() == 0){
        $('#myContent').val(1);
    } else {
        $('#myContent').val(0);
    }
    let params = $('#frm2').serialize();
    $.ajax({
        url :"/experienceForm.do",
        data : params,
        datatype : 'text',
        type : "GET",
        success : function(result){
            let html = jQuery('<div>').html(result);
            let contents = html.find("div#contentTable").html();
            $('#contentTable').html(contents);
        }
    });
}

function popUp(){
    $('#name').val('');
    $('#phone_No').val('');
    $('#popup').css('display', 'flex').hide().fadeIn();
}

function modalClose(){
    $('#popup').fadeOut();
}

function regUser(){
    let name = $('#name').val();
    let phone_No = $('#phone_No').val();
    if(name == null || name == ""){
        alert('이름을 입력해 주세요.');
        $('#name').focus();
        return;
    }
    if(phone_No == null || phone_No == ""){
        alert('휴대폰 번호를 입력해 주세요.');
        $('#phone_No').focus();
        return;
    }
    if(phone_No.split('-').length != 3){
        alert('핸드폰 번호 형식이 맞지 않습니다.');
        $('#phone_No').val('');
        $('#phone_No').focus();
        return;
    }
    if(confirm('로그인 및 사용자 등록 하시겠습니까?')){
        let params = $('#frm3').serialize();
        $.ajax({
            url :"/join/regUser",
            data : params,
            datatype : 'text',
            type : "POST",
            success : function(result){
                if(result == 'notName') {
                    alert('등록된 사용자 이름과 일치하지 않습니다.');
                } else if(result == 'success'){
                    alert('사용자 등록이 완료되었습니다.');
                    modalClose()
                    location.reload();
                } else {
                    modalClose()
                    location.reload();
                }
            }
        });
    }
}
// 댓글 입력 input 글자 수 제한
function lenthCheck(){
    let content = $('#content').val();
    $("#textLengthCheck").text("" + content.length + " / 500자"); //실시간 글자수 카운팅
    if (content.length > 500) {
        alert("최대 500자까지 입력 가능합니다.");
        $('#content').val(content.substring(0, 500));
        $('#textLengthCheck').text("500 / 500자");
    }
};