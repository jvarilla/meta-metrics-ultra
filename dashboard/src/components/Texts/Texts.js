import React, { Component } from 'react';
import './Texts.css';

class Texts extends Component{
	render(){
		return(
      	<div>
      		 <p className="texts-paragraph">{this.props.text}</p>
		</div>
		);
	}
}

export default Texts;