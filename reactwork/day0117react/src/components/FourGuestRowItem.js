import React from "react";
import {DeleteForeverOutlined} from "@mui/icons-material";

const FourGuestRowItem = ({item, onDelete}) => {
  // .env(공통된 환경변수 등록) - 가져오는 방법
  const imageStorage = process.env.REACT_APP_STORAGE;

  // 삭제 이벤트에서 호출하는 함수 방법2
  const deleteData = (guestNum) => {
    let picDelete = window.confirm("삭제할까요?");
    if (picDelete) {
      onDelete(guestNum);
    }
  };

  return (
    <div
      style={{
        border: "2px groove gray",
        width: "400px",
        height: "auto",
        padding: "10px",
        margin: "10px",
        borderRadius: "30px",
      }}
    >
      <span>
        <b>{item.nickname}</b>
        <DeleteForeverOutlined onClick={() => onDelete(item.guestNum)} />
      </span>
      <span style={{color: "gray", fontSize: "0.9em", float: "right"}}>
        <b>{item.writeday}</b>
      </span>
      <img alt="" src={imageStorage + item.photo} style={{width: "200px"}} />
      <pre style={{marginTop: "10px", fontWeight: "bold"}}>{item.content}</pre>
    </div>
  );
};

export default FourGuestRowItem;
