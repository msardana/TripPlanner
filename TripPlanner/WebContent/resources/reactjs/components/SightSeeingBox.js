import React from 'react';

import DatePicker from 'react-datepicker';
import moment from 'moment';


export default class SightSeeingBox extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            startDate: moment()
        }
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(date) {
        this.setState({
        startDate: date
       });
   }

    firstMethod(e) {
        const re = /[a-zA-Z:]+/g;
        if (!re.test(e.key)) {
        e.preventDefault();
     }
   }

   secondMethod(e) {
        const re = /[0-9:]+/g;
        if (!re.test(e.key)) {
        e.preventDefault();
    }
  }


    setAge(event){
        this.setState({lastName : event.target.value});
    }
    displayUser(event){
        let data = this.state.firstName + this.state.lastName;
        document.getElementById("display").innerHTML=data;
    }
    render(){
        const ser={
        width: '28em',
        height: '3em',
        textAlign: 'center',
        padding : '0px',
        marginTop : '10px',
        marginBottom: '10px'
      }

   return <div id="total" className="container-fluid">
   <h4 id="cen">PLAN SIGHTSEEING </h4>
   <div className="row">
   <div className="col col-lg-6">
   <div className="input-group">
   <div className="input-group-addon">
   <span className="glyphicon glyphicon-map-marker" id="basic-addon1"></span>
   </div>
   <input type="text"  placeholder="Select tour destination "  onKeyPress={(e) => this.firstMethod(e)}  aria-describedby="basic-addon1"/>
   </div>
   <p>
   </p>
   <div className="input-group">
   <span className="input-group-addon" id="basic-addon1">@</span>
   <input type="text" placeholder="Start from" onKeyPress={(e) => this.firstMethod(e)} aria-describedby="basic-addon1"/>
   </div>
   <p>
   </p>
   <div className="input-group">
   <span className="input-group-addon" id="basic-addon1">@</span>
   <DatePicker
        selected={this.state.startDate}
        onChange={this.handleChange}
        placeholderText="Click to select a date"
    />
  </div>
  <p>
  </p>
  <div className="input-group">
  <span className="input-group-addon" id="basic-addon1">@</span>
  <input type="text"  placeholder="No of people"   onKeyPress={(e) => this.secondMethod(e)} aria-describedby="basic-addon1"/>
  </div>
  <p>
  </p>
  <div className="input-group">
  <span className="input-group-addon" id="basic-addon1">@</span>
  <input type="text" class="form-control" onKeyPress={(e) => this.firstMethod(e)}  id="pwd"/>
  </div>
  <p>
  </p>
  <div id="textbox1" className="form-group">
    <label for="formGroupExampleInput2"></label>
    <select type="text" className="col-xs-5" placeholder="Males"  onKeyPress={(e) => this.secondMethod(e)}>
         <option value="" disabled selected>Males</option>
         <option value="val1">0 Male</option>
         <option value="val2">1 Male</option>
         <option value="val3">2 Males</option>
         <option value="val4">3 Males</option>
    </select>
</div>
<div id="textbox2" className="form-group">
    <label for="formGroupExampleInput2"></label>
    <select type="text" className="col-xs-5" placeholder="Fenales"  onKeyPress={(e) => this.secondMethod(e)}>
         <option value="" disabled selected>Females</option>
         <option value="val1">0 Female</option>
         <option value="val2">1 Female</option>
         <option value="val3">2 Females</option>
         <option value="val4">3 Females</option>
    </select>
</div>

                    <p></p>
                    <div id="textbox3" className="form-group">
                       <label for="formGroupExampleInput2"></label>

                       <select type="text" className="col-xs-5" placeholder="Kids"  onKeyPress={(e) => this.secondMethod(e)}>
                            <option value="" disabled selected>Kids</option>
                            <option value="val1">0 Child</option>
                            <option value="val2">1 Child</option>
                            <option value="val3">2 Children</option>
                            <option value="val4">3 Children</option>
                       </select>

                    </div>
                    <div id="textbox4" className="form-group">
                       <label for="formGroupExampleInput2"></label>
                       <select className="col-xs-5" placeholder="Seniors"  onKeyPress={(e) => this.secondMethod(e)}>
                            <option value="" disabled selected>Seniors</option>
                            <option value="val1">0 Seniors</option>
                            <option value="val2">1 Seniors</option>
                            <option value="val3">2 Seniors</option>
                            <option value="val4">3 Seniorsn</option>
                       </select>

                    </div>
                    <p id="display"></p>
                    <button type="submit" style={ser} id="search" className="btn btn-primary" onClick={this.displayUser.bind(this)}>SEARCH SIGHT SEEING</button>
                </div>
               </div>
              </div>


    }
}
