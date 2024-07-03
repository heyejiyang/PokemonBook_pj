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

    /* 파일 업로드 버튼 클릭 처리 S*/
    const fileUploadButtons = document.getElementsByClassName("file-upload");
    //<input type='file'>
    const fileEl = document.createElement("input");
    fileEl.type = 'file';
    fileEl.multiple = true;

    // gid
    const gidEl = document.querySelector("input[name='gid']");
    const gid = gidEl ? gidEl.value : Date.now();

    for(const el of fileUploadButtons){
        el.addEventListener("click", function (){
            // editor - 에디터에 추가될 이미지, attach - 첨부 파일
            const location = this.classList.contains("editor") ? "editor" : "attach";
            fileEl.location = location;

            fileEl.click();
        });
    }
    /* 파일 업로드 버튼 클릭 처리 E*/

    /* 파일 탐색기에서 선택 처리 S*/
    fileEl.addEventListener("change", function (e){
        try{
            const files = e.target.files; //업로드한 파일 목록

            // 에디터에 첨부되는 이미지이므로 형식 체크
            if(fileEl.location == 'editor'){
                for(const file of files){
                    // 이미지 형식의 파일이 아닌경우
                    if(file.type.indexOf("image/") == -1){
                        throw new Error("이미지 형식만 업로드 하세요.");
                    }
                }
            }

            //파일 업로드
            fileManager.upload(files, gid, location);

        }catch (err){
            alert(err.message);
        }
    });
    /* 파일 탐색기에서 선택 처리 E*/
});