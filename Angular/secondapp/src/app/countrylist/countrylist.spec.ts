import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Countrylist } from './countrylist';

describe('Countrylist', () => {
  let component: Countrylist;
  let fixture: ComponentFixture<Countrylist>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Countrylist]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Countrylist);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
