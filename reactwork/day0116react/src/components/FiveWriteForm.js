import {Button} from "@mui/material";
import React, {useState} from "react";

function FiveWriteForm({onSave}) {
  const [foodName, setFoodName] = useState("");
  const [foodPhoto, setFoodPhoto] = useState("");
  const [foodPrice, setFoodPrice] = useState(0);

  // 추가 이벤트
  const onAddEvent = () => {
    onSave({foodName, foodPhoto, foodPrice});
    // 초기화
    setFoodName("");
    setFoodPrice(0);
  };

  return (
    <div className="input-group">
      메뉴명:
      <input
        type="text"
        value={foodName}
        onChange={(e) => setFoodName(e.target.value)}
        style={{width: "100px"}}
      />
      가격:
      <input
        type="text"
        value={foodPrice}
        onChange={(e) => setFoodPrice(e.target.value)}
        style={{width: "100px"}}
      />
      사진:
      <select onChange={(e) => setFoodPhoto(e.target.value)}>
        <option value={"2.jpg"}>꼬치종류</option>
        <option value={"4.jpg"}>카레종류</option>
        <option value={"8.jpg"}>샌드위치종류</option>
        <option value={"11.jpg"}>빙수종류</option>
      </select>
      <Button
        color="warning"
        variant="outlined"
        size="small"
        onClick={onAddEvent}
      >
        추가
      </Button>
    </div>
  );
}

export default FiveWriteForm;
