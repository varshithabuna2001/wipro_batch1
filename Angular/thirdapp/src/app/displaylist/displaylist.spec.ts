import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Displaylist } from './displaylist';

describe('Displaylist', () => {
  let component: Displaylist;
  let fixture: ComponentFixture<Displaylist>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Displaylist]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Displaylist);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
