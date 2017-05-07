import { BoartFrontPage } from './app.po';

describe('boart-front App', function() {
  let page: BoartFrontPage;

  beforeEach(() => {
    page = new BoartFrontPage();
  });

  it('should display a list of publications.', () => {
    page.navigateTo();
    page.getPublicationElement();
  });

  it('should go to login page and do login.', () => {
    page.navigateTo();
    page.getLoginButton().click();
    page.getLoginUsernameField().sendKeys('gcuencam');
    page.getLoginPasswordField().sendKeys('1234');
    page.getSubmitInput().click();
    expect<any>(page.getLoginUsernameText()).toEqual('Gabriel');
  });

  it('should do upload. Required login.', () => {
    page.navigateTo();
    page.getUploadButton().click();
    page.getUploadTitleField().sendKeys('Best of Placebo');
    page.getUploadDescriptionField().sendKeys('Best songs');
    page.getUploadTagsField().sendKeys('Placebo');
    page.getUploadVideoField().click();
    page.getUploadVideoUrlField().sendKeys('RTCGZ2b6xzw');
    page.getSubmitButton().click();
    expect<any>(page.getPublicationElement());
  });


});
