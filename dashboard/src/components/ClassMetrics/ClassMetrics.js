import React, { Component } from 'react';

class ClassMetrics extends Component {
    render() {
        if (this.props.classMetrics) {
            return (
                <div>
                    <h1>
                        {this.props.classMetrics.className}
                    </h1>
                    <h3>Ancestors:</h3>
                    <ol>
                        {this.props.classMetrics.dit.ancestors.map(((v, i) => {
                            return (<li key={i}>{ v.toString() }</li> )
                        }))}
                    </ol>
                   
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