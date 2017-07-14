import React from 'react';
import LoginRegister from "./LoginRegister";
import TransportMode from "./TransportMode";
import SightSeeingBox from "./SightSeeingBox";
import SideMenu from "./SideMenu"

import Planbox from "./Planbox"
export default class DestinationDetailBox extends React.Component{

    render(){
        return (
     <div className="container" id="s">
       
             <div id="a4">
               <LoginRegister/>
             </div>
             <div id="a5">
               <Planbox/>
             </div>
        <div id="a3">
              <div id="a2">
                <SideMenu/>
              </div>
        </div>
     </div>
      )
    }
}
