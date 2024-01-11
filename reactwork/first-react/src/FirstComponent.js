import React from "react";
import "./MyStyle.css";
import image02 from "./image_bg02.jpg";
import T1 from "./T1_1.jpg";

let FirstComponent = () => {
  return (
    <div className="box">
      <h3 className="alert alert-danger">FirstComponent 컴포넌트</h3>
      <h6>public 의 이미지 나타내기</h6>
      {/* public 이미지는 직접 경로로 지정해야함 - 권장안함*/}
      <img
        alt=""
        src="./imgText_bg02.jpg"
        style={{ border: "3px solid pink", width: "100px" }}
      />
      <h6>src 의 이미지 나타내기</h6>
      <img
        alt=""
        src={image02}
        style={{ border: "3px solid pink", width: "100px" }}
      />
      <img
        alt=""
        src={T1}
        style={{ border: "3px solid pink", width: "100px", marginLeft: "10px" }}
      />
    </div>
  );
};

export default FirstComponent;
