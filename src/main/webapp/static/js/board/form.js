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

    /* 파일 업로드 버튼 클릭 처리 S */
    const fileUploadButtons = document.getElementsByClassName("file-upload");
    // <input type='file'>
    const fileEl = document.createElement("input");
    fileEl.type = 'file';
    fileEl.multiple = true;

    // gid
    const gidEl = document.querySelector("input[name='gId']");
    const gid = gidEl ? gidEl.value : Date.now();

    for (const el of fileUploadButtons) {
        el.addEventListener("click", function() {
            // editor - 에디터에 추가될 이미지, attach - 첨부 파일
            const location = this.classList.contains("editor") ? "editor" : "attach";
            fileEl.location = location;
            fileEl.value = "";
            fileEl.click();
        });
    }
    /* 파일 업로드 버튼 클릭 처리 E */

    /* 파일 탐색기에서 선택 처리 S */
    fileEl.addEventListener("change", function(e) {

        try {
            const files = e.target.files; // 업로드한 파일 목록

            // 에디터에 첨부되는 이미지이므로 형식 체크
            if (fileEl.location == 'editor') {
                for (const file of files) {
                    // 이미지 형식의 파일이 아닌 경우
                    if (file.type.indexOf("image/") == -1) {
                        throw new Error("이미지 형식만 업로드 하세요.");
                    }
                }
            }

            // 파일 업로드
            fileManager.upload(files, gid, fileEl.location);

        } catch (err) {
            alert(err.message);
        }

    });
    /* 파일 탐색기에서 선택 처리 E */

    /* 이미지 본문 추가 처리 S */
    const insertEditors = document.getElementsByClassName("insert-editor");
    for (const el of insertEditors){
        el.addEventListener("click", (e) => insertEditor(e.currentTarget.dataset.url));
    }
    /* 이미지 본문 추가 처리 E */
});

/**
 * 파일 업로드 후 후속 처리
 * @param files
 */
function callbackFileUpload(files){
    if(files.length == 0){
        return;
    }
    const targetEditor = document.getElementById("attach-files-editor");
    const targetAttach = document.getElementById("attach-files-attach");

    const editorTpl = document.getElementById("editor-tpl").innerHTML;
    const attachTpl = document.getElementById("attach-tpl").innerHTML;

    const domParser = new DOMParser();

    const source = [];
    for(const file of files){
        const location = file.location;
        let html, target;
        if(location == 'editor'){ //에디터에 이미지 추가
            source.push(file.fileUrl);
            html = editorTpl;
            target = targetEditor;
        }else{ //파일 첨부
            html = attachTpl;
            target = targetAttach;
        }

        html = html.replace(/\[seq\]/g, file.seq)
            .replace(/\[fileName\]/g,file.fileName)
            .replace(/\[fileUrl\]/g,file.fileUrl);

        const dom = domParser.parseFromString(html,"text/html");
        const span = dom.querySelector("span");
        target.appendChild(span);

        const insertEditorEl = span.querySelector(".insert-editor");
        if(insertEditorEl) {
            insertEditorEl.addEventListener("click", e => insertEditor(e.currentTarget.dataset.url));
        }
    }

    //에디터에 이미지 추가
    if(source.length > 0){
        editor.execute('insertImage',{ source });
    }
}

/**
* 본문 이미지 추가
*
*/
function insertEditor(imageUrl){
    editor.execute('insertImage', {source: [imageUrl] });
}

/**
* 파일 삭제 후속 처리
*
*/
function callbackFileDelete(seq) {
    const el = document.getElementById(`file-item-${seq}`);
    if (el) {
        el.parentElement.removeChild(el);
    }
}