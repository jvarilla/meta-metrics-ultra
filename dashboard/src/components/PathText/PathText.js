import React, { Component } from 'react';
import './PathText.css';

class PathText extends Component{
	render(){
		return(
      	<div>
        	<h5 className="PathText">Path: {this.props.text}</h5>
		</div>
		);
	}
}

export default PathText;