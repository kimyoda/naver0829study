import axios from "axios";
import React, {useEffect, useState} from "react";
import {Link, useNavigate, useParams} from "react-router-dom";
import BoardRowItem from "./BoardRowItem";

const BoardList = () => {
  const [data, setData] = useState({});
  const [search, setSearch] = useState("");

  const navi = useNavigate();
  const {currentPage} = useParams();
  console.log(currentPage); // 값이 없으면 undefined(null)

  const boardList = () => {
    const url =
      "/board/list?currentPage=" +
      (currentPage == null ? 1 : currentPage) +
      "&search=" +
      search;
    axios.get(url).then((res) => {
      console.log(res.data);
      setData(res.data);
      console.log(res.data.list);
    });
  };

  // useEffect(() => {
  //     console.log('boardList useEffect 1');
  //     boardList();
  // }, []); // 처음 시작 시 한번만 실행

  useEffect(() => {
    console.log("boardList useEffect 2");
    boardList();
  }, [currentPage, search]); // 페이지 or 검색어가 바뀌면 useEffect 실행
  return (
    <div>
      <h4 className="alert alert-danger">
        게시판목록
        {sessionStorage.token && (
          <button
            type="button"
            className="btn btn-danger"
            onClick={() => navi("/board/form")}
            style={{float: "right"}}
          >
            글쓰기
          </button>
        )}
      </h4>
      <table className="table table-bordered" style={{width: "600px"}}>
        <thead>
          <tr>
            <th style={{width: "60px", backgroundColor: "#ddd"}}>번호</th>
            <th style={{width: "350px", backgroundColor: "#ddd"}}>제목</th>
            <th style={{width: "100px", backgroundColor: "#ddd"}}>작성자</th>
            <th style={{width: "60px", backgroundColor: "#ddd"}}>조회</th>
            <th style={{width: "130px", backgroundColor: "#ddd"}}>작성일</th>
          </tr>
        </thead>
        <tbody>
          {data.list &&
            data.list.map((item, idx) => (
              <BoardRowItem key={idx} item={item} idx={idx} no={data.no} />
            ))}
        </tbody>
      </table>
      <div style={{width: "700px", textAlign: "center"}}>
        {data.startPage > 1 && (
          <Link to={"/board/list/" + (data.startPage - 1)} className="pagenum">
            <b style={{color: "black"}}>이전</b>
          </Link>
        )}
        {data.parr &&
          data.parr.map((item, idx) => (
            <Link to={"/board/list/" + item} className="pagenum" key={idx}>
              <b style={{color: "black"}}>{item}</b>
            </Link>
          ))}
        {data.endPage < data.totalPage && (
          <Link to={"/board/list/" + (data.endPage + 1)} className="pagenum">
            <b style={{color: "black"}}>다음</b>
          </Link>
        )}
      </div>
    </div>
  );
};

export default BoardList;
