import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { NavLink } from 'react-router-dom';
import Texts from '../../components/Texts/Texts';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { fas } from "@fortawesome/free-solid-svg-icons";
import './MetricsAll.css';

class MetricsAll extends Component{
	render(){
		if (this.props.metricsData) {
			return(
				<div>
				<div className="text-center pt-3"><Texts text="All Metrics"/></div>
					 <div className="list-group">
						 {this.props.metricsData.classes.map((v, i) => 
							 <NavLink to={"/metrics/classes/"+i} key={"class"+i} activeClassName="active" className="list-group-item list-group-item-action"><FontAwesomeIcon icon="chart-bar" />&nbsp;{v.className}</NavLink>
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