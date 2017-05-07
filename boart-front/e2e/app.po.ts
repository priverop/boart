import { browser, element, by } from 'protractor';

export class BoartFrontPage {
  navigateTo() {
    return browser.get('http://localhost:4200/');
  }

  getPublicationElement() {
    return element.all(by.css('.publication'));
  }

  getLoginButton() {
    return element(by.css('#sing_in'));
  }

  getUploadButton() {
    return element(by.css('#upload'));
  }

  getLoginUsernameField() {
    return element(by.css('input[name=username]'));
  }

  getLoginPasswordField() {
    return element(by.css('input[name=password]'));
  }

  getSubmitInput() {
    return element(by.css('input[type=submit]'));
  }

  getSubmitButton() {
    return element(by.css('button[type=submit]'));
  }

  getLoginUsernameText() {
    return element(by.css('#sign_in')).getText();
  }

  getUploadTitleField() {
    return element(by.css('input[name=titulo]'));
  }

  getUploadDescriptionField() {
    return element(by.css('textarea[name=descripcion]'));
  }

  getUploadTagsField() {
    return element(by.css('textarea[name=etiquetas]'));
  }

  getUploadVideoField() {
    return element(by.css('#optionsRadios3'));
  }

  getUploadVideoUrlField() {
    return element(by.css('input[name=video]'));
  }

  getFirstTitlePublication() {
    return element(by.css('.title_publication')).getText();
  }
}
