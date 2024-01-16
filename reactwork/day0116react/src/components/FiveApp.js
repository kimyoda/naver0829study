import React, {useState} from "react";
import FiveRowItem from "./FiveRowItem";
import FiveWriteForm from "./FiveWriteForm";

function MainApp(props) {
  const [foodArray, setFoodArray] = useState([
    {
      foodName: "망고빙수",
      foodPhoto: "11.jpg",
      foodPrice: "12000",
      foodDate: new Date(),
    },
    {
      foodName: "샌드위치",
      foodPhoto: "1.jpg",
      foodPrice: "9900",
      foodDate: new Date(),
    },
  ]);

  // 데이타 추가 이벤트
  const dataAdd = (data) => {
    setFoodArray(
      foodArray.concat({
        ...data,
        foodDate: new Date(),
      })
    );
  };

  // 데이타 삭제 이벤트
  const dataDelete = (idx) => {
    setFoodArray(foodArray.filter((delData, i) => i !== idx));
  };

  return (
    <div>
      <h3 className="alert alert-danger">FiveApp</h3>
      {/* 입력폼 */}
      <FiveWriteForm onSave={dataAdd} />
      <hr />
      <table className="table table-bordered" style={{width: "400px"}}>
        <thead>
          <tr>
            <th style={{width: "50px"}}>번호</th>
            <th style={{width: "120px"}}>메뉴명</th>
            <th style={{width: "120px"}}>가격</th>
            <th style={{width: "120px"}}>날짜</th>
          </tr>
        </thead>
        <tbody>
          {foodArray.map((data, idx) => (
            <FiveRowItem key={idx} row={data} idx={idx} onDelete={dataDelete} />
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default MainApp;
