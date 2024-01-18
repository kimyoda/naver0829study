import {Alert} from "@mui/material";
import React from "react";

const HomeSub3 = () => {
  return (
    <div>
      <Alert variant="filled" severity="primary">
        오시는 길 <br />
      </Alert>
      <iframe
        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d50650.47488683738!2d127.00868802590792!3d37.492474505727245!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca15aee9ab0cb%3A0x31793fc63e0cf9d3!2z67mE7Yq47Lqg7ZSE!5e0!3m2!1sko!2skr!4v1705562560084!5m2!1sko!2skr"
        width="600"
        height="450"
        style={{border: 0}}
        allowfullscreen=""
        loading="lazy"
        referrerpolicy="no-referrer-when-downgrade"
      ></iframe>
    </div>
  );
};

export default HomeSub3;
