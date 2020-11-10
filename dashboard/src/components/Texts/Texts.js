import React, { Component } from 'react';
//import './LargeTitle.css';

class Texts extends Component{
	render(){
		return(
      	<div>
      		 <p>{this.props.text}</p>
		</div>
		);
	}
}

export default Texts;