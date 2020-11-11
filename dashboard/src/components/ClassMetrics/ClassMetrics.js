import React, { Component } from 'react';
import MetricsAll from '../MetricsAll/MetricsAll';
import MobileMetricsMenu from '../MobileMetricsMenu/MobileMetricsMenu';
import Breadcrumbs from '../Breadcrumbs/Breadcrumbs';
import LargeTitle from '../LargeTitle/LargeTitle';
import Texts from '../Texts/Texts';
import Summary from '../Summary/Summary';


class ClassMetrics extends Component {
    render() {
        if (this.props.metricsData) {
            return (
                <div>  
                   <h1>test</h1>
                </div>
            )
        } else {
            return (
                <div>
                    No Class Found... 
                </div>
            )
        }
    }
}

export default ClassMetrics;