import React, { PureComponent } from 'react';
import {
  PieChart, Pie, Legend, Tooltip,
} from 'recharts';

export default class Example extends PureComponent {
  static jsfiddleUrl = 'https://jsfiddle.net/alidingling/k9jkog04/';

  render() {
    const data = this.props.metricsData;
    return (
      <div>
      <h2>{this.props.title}</h2>
      <PieChart width={300} height={385}>
        <Pie dataKey="value" isAnimationActive={false} data={data} cx={150} cy={120} outerRadius={80} fill="#1717BF" label />
        <Tooltip />
        <Legend/>
      </PieChart>
      </div>
    );
  }
}