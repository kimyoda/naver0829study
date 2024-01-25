import axios from "axios";
import React, {useState} from "react";
import {useNavigate} from "react-router-dom";

const BoardForm = () => {
  const [pre_img, setPre_img] = useState("");
  const [file, setFile] = useState("");
  const [subject, setSubject] = useState("");
  const [content, setContent] = useState("");

  const navi = useNavigate();

  const onUploadChange = (e) => {
    e.preventDefault();

    setFile(e.target.files[0]);

    // 미리보기 위해 fileReader에 넣기
    const fileReader = new FileReader();

    if (e.target.files[0]) {
      fileReader.readAsDataURL(e.target.files[0]);
    }

    fileReader.onload = () => {
      setPre_img(fileReader.result);
    };
  };

  const onSubmitEvent = (e) => {
    e.preventDefault();
    console.log(file);

    const formData = new FormData();
    formData.append("upload", file);
    formData.append("token", sessionStorage.token);
    formData.append("subject", subject);
    formData.append("content", content);

    axios({
      method: "post",
      url: "/board/insert",
      data: formData,
      headers: {"Content-Type": "multipart/form-data"},
    }).then((res) => {
      // 추가 성공 후 목록으로 이동
      navi("/board/list");
    });
  };

  return (
    <div>
      {sessionStorage.token == null ? (
        <div>
          <h4 className="alert alert-danger">
            회원 전용 글쓰기만 페이지입니다
          </h4>
        </div>
      ) : (
        <div>
          <h4 className="alert alert-danger">게시판 글쓰기</h4>
          <form onSubmit={onSubmitEvent}>
            <div className="input-group" style={{width: "400px"}}>
              <input
                type="text"
                className="form-control"
                required
                placeholder="제목을 입력해주세요"
                value={subject}
                onChange={(e) => setSubject(e.target.value)}
              />
            </div>
            <div className="input-group" style={{width: "400px"}}>
              <input
                type="file"
                className="form-control"
                onChange={onUploadChange}
              />
              <img
                alt=""
                src={pre_img}
                style={{maxWidth: "200px", marginLeft: "20px"}}
              />
            </div>
            <div className="input-group" style={{width: "400px"}}>
              <textarea
                className="form-control"
                required
                style={{marginTop: "10px", height: "150px"}}
                placeholder="내용을 입력해주세요"
                value={content}
                onChange={(e) => setContent(e.target.value)}
              />
            </div>
            <br />
            <button type="submit" className="btn btn-success">
              글저장
            </button>
          </form>
        </div>
      )}
    </div>
  );
};

export default BoardForm;
