import React, { Component } from 'react';
import './LargeTitle.css';

class LargeTitle extends Component{
	render(){
		return(
      	<div>
        	<h1 className="LargeTitle">{this.props.name}</h1>
		</div>
		);
	}
}

export default LargeTitle;