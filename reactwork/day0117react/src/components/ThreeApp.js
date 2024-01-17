import {Alert} from "@mui/material";
import axios from "axios";
import React, {useEffect, useState} from "react";
import ThreeCardApp from "./ThreeCardApp";

function ThreeApp(props) {
  const [personList, setPersonList] = useState([]);

  const list = () => {
    // 백엔드로부터 데이타를 가져와서 배열변수에 넣기
    axios.get("/person/list").then((res) => {
      setPersonList(res.data);
    });
  };

  useEffect(() => {
    console.log("useEffect");
    list(); // 처음 시작 시 무조건 호출, 두번 보이지만 한번만 호출돼는 것이다.
  }, []); // 처음 시작 시 한번만 호출

  return (
    <div>
      <Alert severity="warning" variant="filled">
        <h3>ThreeApp-mui Card를 이용한 목록 출력</h3>
      </Alert>
      {personList.map((item, idx) => (
        <div>
          <ThreeCardApp key={idx} item={item} />
          <hr />
        </div>
      ))}
    </div>
  );
}

export default ThreeApp;
