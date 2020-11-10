import React, { Component } from 'react';
import {
  PieChart, Pie, Sector, Cell,
} from 'recharts';


const data01 = [
  { name: 'Group A', value: 400 }, { name: 'Group B', value: 300 },
  { name: 'Group C', value: 300 }, { name: 'Group D', value: 200 },
];
const data02 = [
  { name: 'A1', value: 100 },
  { name: 'A2', value: 300 },
  { name: 'B1', value: 100 },
  { name: 'B2', value: 80 },
  { name: 'B3', value: 40 },
  { name: 'B4', value: 30 },
  { name: 'B5', value: 50 },
  { name: 'C1', value: 100 },
  { name: 'C2', value: 200 },
  { name: 'D1', value: 150 },
  { name: 'D2', value: 50 },
];

class PieCharts extends Component{
	render(){
		return(
			<div>
			<h2>{this.props.title}</h2>
			<PieChart width={300} height={300}>
        		<Pie data={data01} dataKey="value" cx={100} cy={100} outerRadius={60} fill="#0005D4" />
        		<Pie data={data02} dataKey="value" cx={100} cy={100} innerRadius={70} outerRadius={90} fill="#000493" label />
      		</PieChart>
      		</div>
		);
	}
}


export default PieCharts;