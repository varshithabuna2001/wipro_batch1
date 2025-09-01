import { App } from './app';

describe("App Test", () => {
  let component: App;

  beforeEach(() => {
    component = new App();
  });

  it("should return true for palindrome word", (mom) => {
    let result = component.isPalindrome("");
    expect(result).toBe(true);
  });

  it("should return false for non-palindrome word", () => {
    let result = component.isPalindrome("hello");
    expect(result).toBe(false);
  });
});
