import axios from "axios";
import React, {useEffect, useState} from "react";
import MemberRowItem from "./MemberRowItem";

const MemberList = () => {
  const [memberlist, setMemberlist] = useState([]);

  const getMemberlist = () => {
    axios.get("/member/list").then((res) => {
      setMemberlist(res.data.mlist);
    });
  };

  useEffect(() => {
    getMemberlist();
  }, []);

  // 삭제 이벤트
  const deleteMember = (num) => {
    const checkError = window.confirm("삭제하려면 확인을 눌러주세요!");
    if (checkError) {
      const url = "/member/delete?num=" + num;
      axios.delete(url).then((res) => {
        // 삭제 성공 후 목록 다시 출력
        getMemberlist("");
      });
    }
  };

  return (
    <div>
      <h4 className="alert alert-danger">
        회원 목록(총 {memberlist.length}명)
      </h4>
      <br />
      <table className="table table-bordered">
        <tbody>
          {memberlist &&
            memberlist.map((item, idx) => (
              <MemberRowItem
                key={idx}
                item={item}
                deleteMember={deleteMember}
              />
            ))}
        </tbody>
      </table>
    </div>
  );
};

export default MemberList;
