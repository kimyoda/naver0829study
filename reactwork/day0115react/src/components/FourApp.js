import React from "react";
import "./MyStyle.css";
import img1 from "./images/K-034.png";
import img2 from "./images/K-037.png";
import img3 from "./images/K-039.png";
import img4 from "./images/K-041.png";
function FourApp(props) {
  // 4개의 import 된 이미지를 배열에 저장
  const myImage = [img1, img2, img3, img4];
  const data = [
    {name: "강호동", addr: "서울", Hp: "010-2222-3333", photo: "C1"},
    {name: "김요다", addr: "부산", Hp: "010-1111-5555", photo: "C2"},
    {name: "이쌈수", addr: "울산", Hp: "010-7777-7777", photo: "C3"},
    {name: "제리이", addr: "대구", Hp: "010-6666-6767", photo: "C4"},
  ];

  return (
    <div>
      <h3 className="alert alert-success">FourApp-msp 으로 이미지배열 출력</h3>
      {myImage.map((img, idx) => (
        <img key={idx} alt="" src={img} width="100" />
      ))}
      <hr />
      {data.map((ele, i) => (
        <div className="box" key={ele.name}>
          <h5>이름: {ele.name}</h5>
          <h5>주소: {ele.addr}</h5>
          <h5>핸드폰: {ele.Hp}</h5>
          <img
            alt="프로필사진"
            src={require(`./images/${ele.photo}.png`)}
            width="120"
          />
        </div>
      ))}
      <hr />
      <table className="table tabler-bordered" style={{width: "500px"}}>
        <thead>
          <tr>
            <th width="40">번호</th>
            <th width="100">사진</th>
            <th width="100">이름</th>
            <th width="150">핸드폰</th>
            <th width="200">주소</th>
          </tr>
        </thead>
        <tbody>
          {data.map((ele, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>
                <img
                  alt="프로필사진"
                  src={require(`./images/${ele.photo}.png`)}
                  width="50"
                />
              </td>
              <td>{ele.name}</td>
              <td>{ele.Hp}</td>
              <td>{ele.addr}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default FourApp;
