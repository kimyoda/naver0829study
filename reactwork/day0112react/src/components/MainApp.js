import React, { useState } from "react";
// import OneApp from "./OneApp.js"; // deaful로 export 한 경우
// import { OneApp } from "./OneApp"; // default 없이 export 한 경우
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import { OneApp } from "./OneApp";

function MainApp(props) {
  const [comp, setComp] = useState(5); // 컴포넌트 번호
  

  return (
    <div>
      <h3>2024-01-12 리액트 수업</h3>
      <hr/>
      <select className='form-select' style={{width:'300px'}}
      onChange={(e) => {
        setComp(Number(e.target.value));
      }}>
        <option value={1}>OneApp-이미지, 스타일, 클래스</option>
        <option value={2}>TwoApp-숫자 올리기 / 내리기 이벤트</option>
        <option value={3}>ThreeApp-이름, 점수입력 이벤트</option>
        <option value={4}>FourApp-input radio 이벤트</option>
        <option value={5} selected>FiveApp-checkbox, select 이미지 이벤트</option>
      </select>
      <br /><br />
      <h5>당신은 {comp} 번 컴포넌트를 선택했습니다</h5>
      {
        // 조건연산자를 이용하여 comp 값에 따라 해당 컴포넌트가 
        // 나오도록 하기
        comp === 1 ? <OneApp /> :
        comp === 2 ? <TwoApp /> :
        comp === 3 ? <ThreeApp /> :
        comp === 4 ? <FourApp /> :
        <FiveApp /> 
      }
    </div>
  );
}

export default MainApp;
