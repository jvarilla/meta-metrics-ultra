import React, { PureComponent } from 'react';
import {
  PieChart, Pie, Sector, Cell, Legend, ResponsiveContainer, Tooltip
} from 'recharts';
import './SimplePieChart.css';

const COLORS = ['#1717BF', '#000062', '#707070', '#000036'];

const RADIAN = Math.PI / 180;

export default class Example extends PureComponent {
  static jsfiddleUrl = 'https://jsfiddle.net/alidingling/c9pL8k61/';

  render() {
    const data = this.props.metricsData;
    return (
    <div className="simplePieChartContainer">
    <h2>{this.props.title}</h2>
    <ResponsiveContainer>
      <PieChart>
        <Pie
          data={data}
          labelLine={true}
          label={(entry) => entry.value.toFixed(1)}
          outerRadius={150}
          fill="#8884d8"
          dataKey="value"
        >
          {
            data.map((entry, index) => <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />)
          }
        </Pie>
        <Tooltip />
        <Legend />
      </PieChart>
      </ResponsiveContainer>
      </div>
    );
  }
}
