import {Alert} from "@mui/material";
import axios from "axios";
import React, {useEffect, useState} from "react";
import ImageList from "@mui/material/ImageList";
import ImageListItem from "@mui/material/ImageListItem";
import ImageListItemBar from "@mui/material/ImageListItemBar";
import ListSubheader from "@mui/material/ListSubheader";
import IconButton from "@mui/material/IconButton";
import InfoIcon from "@mui/icons-material/Info";

function TwoApp(props) {
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
      <Alert severity="info" variant="filled">
        <h3>TwoApp</h3>
      </Alert>
      <ImageList sx={{width: 500, height: 450}}>
        <ImageListItem key="Subheader" cols={2}>
          <ListSubheader component="div">December</ListSubheader>
        </ImageListItem>
        {personList.map((item, idx) => (
          <ImageListItem key={idx}>
            <img
              srcSet={require(`../images/${item.photo}?w=248&fit=crop&auto=format&dpr=2 2x`)}
              src={require(`../images/${item.photo}?w=248&fit=crop&auto=format`)}
              alt={item.name}
              loading="lazy"
            />
            <ImageListItemBar
              title={`이름:${item.name}`}
              subtitle={`나이:${item.age}세`}
              actionIcon={
                <IconButton
                  title={{color: "rgba(255, 255, 255, 0.54)"}}
                  aria-label={`info about ${item.name}`}
                >
                  <InfoIcon />
                </IconButton>
              }
            />
          </ImageListItem>
        ))}
      </ImageList>
    </div>
  );
}

export default TwoApp;
