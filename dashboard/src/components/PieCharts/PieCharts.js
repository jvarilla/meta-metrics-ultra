import React, { PureComponent } from 'react';
import {
  PieChart, Pie, Sector, Cell, Legend, ResponsiveContainer, Tooltip
} from 'recharts';
import './PieCharts.css';

const COLORS = ['#1717BF', '#000062', '#707070', '#FF8042'];

const RADIAN = Math.PI / 180;

export default class Example extends PureComponent {
  static jsfiddleUrl = 'https://jsfiddle.net/alidingling/c9pL8k61/';

  render() {
    const data = this.props.dataForChart;
     console.log(data.length);
    return (
    <div className="pieChartContainer">
    <h2>{this.props.title}</h2>
    <ResponsiveContainer>
      <PieChart>
        <Pie
          data={data}
          labelLine={true}
          label={(entry) => entry.value}
          outerRadius={95}
          fill="#8884d8"
          dataKey="value"
        >
          {
            data.map((entry, index) => <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />)
          }
        </Pie>
        <Tooltip/>
        <Legend />
      </PieChart>
      </ResponsiveContainer>
      </div>
    );
  }
}
