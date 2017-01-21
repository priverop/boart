import { BoartFrontPage } from './app.po';

describe('boart-front App', function() {
  let page: BoartFrontPage;

  beforeEach(() => {
    page = new BoartFrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
