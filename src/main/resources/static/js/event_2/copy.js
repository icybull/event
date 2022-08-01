$('#data-copy1').click(function() {
    $('#data-area1').attr('type', 'text');
    $('#data-area1').select();
    var copy = document.execCommand('copy');
    $('#data-area1').attr('type', 'hidden');
    if(copy) {
    	alert("복사되었습니다.");
    }
});
$('#data-copy2').click(function() {
    $('#data-area2').attr('type', 'text');
    $('#data-area2').select();
    var copy = document.execCommand('copy');
    $('#data-area2').attr('type', 'hidden');
    if(copy) {
    	alert("복사되었습니다.");
    }
});
$('#data-copy3').click(function() {
    $('#data-area3').attr('type', 'text');
    $('#data-area3').select();
    var copy = document.execCommand('copy');
    $('#data-area3').attr('type', 'hidden');
    if(copy) {
    	alert("복사되었습니다.");
    }
});
$('#data-copy4').click(function() {
    $('#data-area4').attr('type', 'text');
    $('#data-area4').select();
    var copy = document.execCommand('copy');
    $('#data-area4').attr('type', 'hidden');
    if(copy) {
    	alert("복사되었습니다.");
    }
});