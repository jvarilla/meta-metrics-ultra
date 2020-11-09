import React, { Component } from 'react';
import metricsData from '../../metricsData';
import Texts from '../../components/Texts/Texts';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { fas } from "@fortawesome/free-solid-svg-icons";

class MetricsAll extends Component{
	render(){
		return(
      <div>
      <Texts text="All Metrics"/>
       	<div class="list-group">
       		{metricsData.classes.map((v, i) => 
       			<a href={"/Metrics/"+v.className} key={"class"+i} class="list-group-item list-group-item-action">{v.className}</a>
       		)}
		</div>
	  </div>
		);
	}
}

export default MetricsAll;