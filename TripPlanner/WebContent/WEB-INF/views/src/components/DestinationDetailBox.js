import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import LoginRegister from "./LoginRegister";
import TransportMode from "./TransportMode";
import SightSeeingBox from "./SightSeeingBox";
export default class DestinationDetailBox extends React.Component{

    render(){
        return (
        <div className="main">
        <div><LoginRegister/></div>
        <div><TransportMode/></div>
        <div><SightSeeingBox/></div>
        </div>
      )
    }
}
