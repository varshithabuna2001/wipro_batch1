import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Changecol } from './changecol';

describe('Changecol', () => {
  let component: Changecol;
  let fixture: ComponentFixture<Changecol>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Changecol]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Changecol);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
