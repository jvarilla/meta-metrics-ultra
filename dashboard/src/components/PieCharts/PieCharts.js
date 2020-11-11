import React, { PureComponent } from 'react';
import {
  PieChart, Pie, Sector, Cell, Legend
} from 'recharts';

const COLORS = ['#1717BF', '#000062', '#707070', '#FF8042'];

const RADIAN = Math.PI / 180;
const renderCustomizedLabel = ({
  cx, cy, midAngle, innerRadius, outerRadius, percent, index,
}) => {
   const radius = innerRadius + (outerRadius - innerRadius) * 0.5;
  const x = cx + radius * Math.cos(-midAngle * RADIAN);
  const y = cy + radius * Math.sin(-midAngle * RADIAN);

  return (
    <text x={x} y={y} fill="white" textAnchor={x > cx ? 'start' : 'end'} dominantBaseline="central">
      {`${percent.toFixed(2)}`}
    </text>
  );

};

export default class Example extends PureComponent {
  static jsfiddleUrl = 'https://jsfiddle.net/alidingling/c9pL8k61/';

  render() {
    const data = this.props.dataForChart;
    return (
    <div>
    <h2>{this.props.title}</h2>
      <PieChart width={300} height={250}>
        <Pie
          data={data}
          cx={140}
          cy={100}
          labelLine={false}
          label={renderCustomizedLabel}
          outerRadius={80}
          fill="#8884d8"
          dataKey="value"
        >
          {
            data.map((entry, index) => <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />)
          }
        </Pie>
        <Legend />
      </PieChart>
      </div>
    );
  }
}
