function eventLoad(e_Cnt){
    $('#E_CNT').val(e_Cnt);
    let params = $('#frm').serialize();
    $.ajax({
        url :"/event/main.do",
        data : params,
        datatype : 'text',
        type : "GET",
        success : function(result){
            let html = jQuery('<div>').html(result);
            let contents = html.find("div#eventTable").html();
            $('#eventTable').html(contents);
        }
    });
}