import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';


export default class SightSeeingBox extends React.Component{
    constructor(props){
        super(props);
        this.state = {

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
    <span className="input-group-addon" id="basic-addon1">@</span>
    <input type="text"  placeholder="Select tour destination " aria-describedby="basic-addon1"/>
  </div>
  <p>
  </p>
  <div className="input-group">
<span className="input-group-addon" id="basic-addon1">@</span>
<input type="text" placeholder="Start from" aria-describedby="basic-addon1"/>
</div>
<p>
</p>
<div className="input-group">
<span className="input-group-addon" id="basic-addon1">@</span>
<input type="text"  placeholder="Date" aria-describedby="basic-addon1"/>
</div>
<p>
</p>
<div className="input-group">
<span className="input-group-addon" id="basic-addon1">@</span>
<input type="text"  placeholder="   no of people" aria-describedby="basic-addon1"/>
</div>
<p>
</p>
<div className="input-group">
<span className="input-group-addon" id="basic-addon1">@</span>
<input type="text" class="form-control" id="pwd"/>
</div>
<p>
</p>
<div id="textbox1" className="form-group">
    <label for="formGroupExampleInput2"></label>
   <input type="text" className="col-xs-5" placeholder="Males"
/>
</div>
<div id="textbox2" className="form-group">
    <label for="formGroupExampleInput2"></label>
   <input type="text" className="col-xs-5" placeholder="Females"
/>
</div>

                    <p></p>
                    <div id="textbox3" className="form-group">

                        <label for="formGroupExampleInput2"></label>
                       <input type="text" className="col-xs-5" placeholder="Kids"
                    />
                    </div>
                    <div id="textbox4" className="form-group">
                        <label for="formGroupExampleInput2"></label>
                       <input type="text" className="col-xs-5" placeholder="Seniors"
                    />
                    </div>
                    <p id="display"></p>
                    <button type="submit" style={ser} id="search" className="btn btn-primary" onClick={this.displayUser.bind(this)}>SEARCH SIGHT SEEING</button>
                </div>
               </div>
              </div>


    }
}
