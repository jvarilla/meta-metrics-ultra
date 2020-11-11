import React, { Component } from 'react';
import Texts from '../../components/Texts/Texts';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { fas } from "@fortawesome/free-solid-svg-icons";
import './MetricsAll.css';

class MetricsAll extends Component{
	render(){
		console.log(this.props.metricsData);
		if (this.props.metricsData) {
			return(
				<div>
				<div className="text-center pt-3"><Texts text="All Metrics"/></div>
					 <div className="list-group">
						 {this.props.metricsData.classes.map((v, i) => 
							 <a href={"/metrics/classes/"+i} key={"class"+i} className="list-group-item list-group-item-action"><FontAwesomeIcon icon="chart-bar" />&nbsp;{v.className}</a>
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