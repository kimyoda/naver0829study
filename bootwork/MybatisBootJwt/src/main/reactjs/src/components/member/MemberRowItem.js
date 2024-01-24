import React from "react";

const MemberRowItem = ({item, deleteMember}) => {
  const imageUrl = process.env.REACT_APP_STORAGE;
  return (
    <tr>
      <td style={{width: "250px"}} align="center" valign="middle">
        <img
          alt=""
          src={imageUrl + item.photo}
          style={{width: "150px", border: "1px solid gray"}}
        />
      </td>
      <td valign="middle">
        <b>이름 : {item.name}</b>
        <br />
        <b>아이디 : {item.myid}</b>
        <br />
        <b>핸드폰 : {item.hp}</b>
        <br />
        <b>주소 : {item.addr}</b>
        <br />
        <b>가입일 : {item.gaipday}</b>
        <br />
        <br />
        <button
          type="button"
          className="btn btn-outline-danger btn-sm"
          onClick={() => deleteMember(item.num)}
        >
          회원삭제
        </button>
      </td>
    </tr>
  );
};

export default MemberRowItem;
