// dom이 로딩된 다음에 열기
window.addEventListener("DOMContentLoaded", function (){
    const editor = ClassicEditor.create(document.getElementById("content"),{
        //너비 높이 등 스타일 수정
        height: 350
    })
        .then((editor) =>{
        window.editor = editor
        //editor로 통제.. 이미지 추가, 내부에 텍스트 가져오기, 템플릿만들기 등등 사용..
        // editor을 전역변수처럼 이용할 수 있도록

    }); //게시물 작성 내용
});