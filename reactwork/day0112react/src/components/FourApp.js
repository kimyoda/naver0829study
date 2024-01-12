import { useState } from "react";
import imgText_bg02 from "../images/imgText_bg02.jpg";
import "./MyStyle.css";

function FourApp(props) {
    const [fname, setFname] = useState('Single Day');
    const [fsize, setFsize] = useState('20px');
    const [fcolor, setFcolor] = useState('blue')

  // 이벤트들
  // 글자색 변경하는 이벤트
  const changeFontColor = (e) => {
    setFcolor(e.target.value);
  }
  // 글자 스타일 변경하는 이벤트
  const changeFontStyle = (e) => {
    setFname(e.target.value);
  }
  // 글자 이름 변경하는 이벤트
  const changeFontSize = (e) => {
    setFsize(e.target.value);
  }
  return (
    <div className='box'>
      <h3 className='alert alert-danger'>FourApp
      <img alt='' src={imgText_bg02} style=
      {{width:'60px', float:'right'}}/>
      </h3>
      <div style={{fontFamily:fname,fontSize:fsize,color:fcolor}}>
        오늘은 즐거운 금요일!!
      </div>
    <div>
      <label>
        <input type='radio' name='fcolor' defaultValue={'red'} 
        defaultChecked onClick={changeFontColor}/>
        빨강
      </label>
      <label style={{marginLeft:'10px'}}>
        <input type='radio' name='fcolor' defaultValue={'blue'} 
        onClick={changeFontColor}/>
        파랑
      </label>
      <label style={{marginLeft:'10px'}}>
        <input type='radio' name='fcolor' defaultValue={'green'} 
        onClick={changeFontColor}/>
        초록
      </label>
      <label style={{marginLeft:'10px'}}>
        <input type='radio' name='fcolor' defaultValue={'magenta'} 
        onClick={changeFontColor}/>
        분홍
      </label>
      </div>
      <div style={{marginTop:'10px'}}>
      <label>
        <input type='radio' name='fname' defaultValue={'Gamja Flower'} 
        onClick={changeFontStyle}/>
        Gamja Flower
      </label>
      <label style={{marginLeft:'10px'}}>
        <input type='radio' name='fname' defaultValue={'Single Day'} 
        defaultChecked onClick={changeFontStyle}/>
        Single Day
      </label>
      <label style={{marginLeft:'10px'}}>
        <input type='radio' name='fname' defaultValue={'Jua'} 
        onClick={changeFontStyle}/>
        Jua
      </label>
      <label style={{marginLeft:'10px'}}>
        <input type='radio' name='fname' defaultValue={'Nanum Pen Script'} 
        onClick={changeFontStyle}/>
        Nanum Pen Script
      </label>

      <div style={{marginTop:'10px'}}>
      <label>
        <input type='radio' name='fsize' defaultValue={'13px'} 
        defaultChecked onClick={changeFontSize}/>
        아주작게
      </label>
      <label style={{marginLeft:'10px'}}>
        <input type='radio' name='fsize' defaultValue={'20px'} 
        onClick={changeFontSize}/>
        작게
      </label>
      <label style={{marginLeft:'10px'}}>
        <input type='radio' name='fsize' defaultValue={'30px'} 
        onClick={changeFontSize}/>
        크게
      </label>
      <label style={{marginLeft:'10px'}}>
        <input type='radio' name='fsize' defaultValue={'40px'} 
        onClick={changeFontSize}/>
        아주크게
      </label>
      </div>
      </div>
    </div>
  );
  }

export default FourApp;