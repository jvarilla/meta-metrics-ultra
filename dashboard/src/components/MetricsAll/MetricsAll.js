import React, { Component } from 'react';
import Texts from '../../components/Texts/Texts';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { fas } from "@fortawesome/free-solid-svg-icons";

class MetricsAll extends Component{
	render(){
		if (this.props.metricsData) {
			return(
				<div>
				<Texts text="All Metrics"/>
					 <div className="list-group">
						 {this.props.metricsData.classes.map((v, i) => 
							 <a href={"/metrics/classes/"+i} key={"class"+i} className="list-group-item list-group-item-action">{v.className}</a>
						 )}
				  </div>
				</div>);
		} else {
			return(
				<div>
					<h2>Loading...</h2>
				</div>
			);
		}
	}
}

export default MetricsAll;