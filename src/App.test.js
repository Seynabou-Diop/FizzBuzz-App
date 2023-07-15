import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import App from './App';

describe('App', () => {
  it('renders the title correctly', () => {
    const { getByText } = render(<App />);
    const titleElement = getByText(/FizzBuzz Application/i);
    expect(titleElement).toBeInTheDocument();
  });

  it('renders the start button correctly', () => {
    const { getByText } = render(<App />);
    const startButton = getByText(/Start FizzBuzz/i);
    expect(startButton).toBeInTheDocument();
  });

  it('calculates and renders the correct FizzBuzz results on button click', () => {
    const { getByText, getAllByTestId } = render(<App />);
    const startButton = getByText(/Start FizzBuzz/i);
    fireEvent.click(startButton);
    const resultElements = getAllByTestId('result');
    expect(resultElements.length).toBe(100);

    const expectedResults = [
      '1', '2', 'Fizz', '4', 'Buzz', 'Fizz', '7', '8', 'Fizz', 'Buzz',
      '11', 'Fizz', '13', '14', 'FizzBuzz', '16', '17', 'Fizz', '19', 'Buzz',
      'Fizz', '22', '23', 'Fizz', 'Buzz', '26', 'Fizz', '28', '29', 'FizzBuzz',
      '31', '32', 'Fizz', '34', 'Buzz', 'Fizz', '37', '38', 'Fizz', 'Buzz',
      '41', 'Fizz', '43', '44', 'FizzBuzz', '46', '47', 'Fizz', '49', 'Buzz',
      'Fizz', '52', '53', 'Fizz', 'Buzz', '56', 'Fizz', '58', '59', 'FizzBuzz',
      '61', '62', 'Fizz', '64', 'Buzz', 'Fizz', '67', '68', 'Fizz', 'Buzz',
      '71', 'Fizz', '73', '74', 'FizzBuzz', '76', '77', 'Fizz', '79', 'Buzz',
      'Fizz', '82', '83', 'Fizz', 'Buzz', '86', 'Fizz', '88', '89', 'FizzBuzz',
      '91', '92', 'Fizz', '94', 'Buzz', 'Fizz', '97', '98', 'Fizz', 'Buzz'
    ];
    

    for (let i = 0; i < resultElements.length; i++) {
      expect(resultElements[i].textContent).toBe(expectedResults[i]);
    }
  });
});
