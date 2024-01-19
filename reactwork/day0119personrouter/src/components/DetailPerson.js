import axios from "axios";
import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {ArrowBack, EditNote} from "@mui/icons-material";

const DetailPerson = () => {
  const {personNum} = useParams();
  const navi = useNavigate();
  const [selectData, setSelectData] = useState("");

  // personNum에 대한 dto를 얻어서 selectData에 넣는다
  const getSelectData = () => {
    const url = "/person/select?personNum=" + personNum;
    axios.get(url).then((res) => {
      setSelectData(res.data);
    });
  };

  // 처음 로딩 시 딱 한번 호출
  useEffect(() => {
    getSelectData();
  }, []);

  return (
    <div className="mainbox">
      <h2>
        <b>{selectData.name}</b>님의 개인정보
      </h2>
      {/* map을 얻거나 db로부터 얻어야 출력이 가능한데, 가져오기전에 실행됄 수도 있다.
      없는상태에서 출력을 하려고하니 오류가 생기는 것이다. 불러오기 전에 useEffect가 호출이 됀다.

      */}
      {selectData.photo && (
        <img
          alt=""
          src={require(`../images/${selectData.photo}`)}
          style={{maxWidth: "350px"}}
        />
      )}
      <hr />
      <h6>
        혈액형 : {selectData.blood}형
        <EditNote
          style={{fontSize: "2em", float: "right", cursor: "pointer"}}
          onClick={() => navi(`/updateform/${selectData.personNum}`)}
        />
      </h6>
      <h6>나 이 : {selectData.age}세</h6>
      <h6>
        가입일 : {selectData.writeday}
        <ArrowBack
          // -1 : 이전 페이지로 이동
          onClick={() => navi(-1)}
          style={{fontSize: "2em", float: "right", cursor: "pointer"}}
        />
      </h6>
    </div>
  );
};

export default DetailPerson;
