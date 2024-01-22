import React from "react";
import img1 from "../image/s1.JPG";
import img2 from "../image/s2.JPG";
import img3 from "../image/s3.JPG";
import img4 from "../image/s4.JPG";
import img5 from "../image/s5.JPG";
import {Button} from "@mui/material";
import Swal from "sweetalert2";

const SweetApp = () => {
  return (
    <div>
      <h3 className="alert alert-danger">SwwetAlert 사용방법</h3>
      <hr />
      <Button
        variant="outlined"
        color="warning"
        onClick={() => {
          Swal.fire("안녕하세요");
        }}
      >
        기본 Alert
      </Button>
      <br />
      <Button
        variant="outlined"
        color="error"
        onClick={() => {
          Swal.fire({
            title: "Swal Test",
            html: "오늘은 즐거운<br />월요일<br /> 아침부터 눈이 왔어요!<br />짜증났어요!!",
            icon: "warning",
            confirmButtonText: "확인",
            confirmButtonColor: "#3085d",
            cancelButtonText: "취소",
            cancelButtonColor: "pink",
            showCancelButton: true,
          }).then((result) => {
            if (result.isConfirmed) {
              Swal.fire("시키는대로 처리했습니다!");
            } else {
              Swal.fire("취소했어요!!");
            }
          });
        }}
      >
        확인, 취소 Alert
      </Button>
      <br />
      <button
        type="button"
        className="btn btn-success"
        onClick={() => {
          Swal.fire({
            title: "사진넣기",
            html: `<h5>사진을 넣어볼까요!!</h5>`,
            imageUrl: img1,
            imageWidth: 60,
            imageHeight: 70,
            showCancelButton: true,
            confirmButtonText: "삭제",
            cancelButtonText: "삭제취소",
          });
        }}
      >
        사진넣기
      </button>
    </div>
  );
};

export default SweetApp;
