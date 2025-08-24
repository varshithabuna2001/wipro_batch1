import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Moviecomponent } from './moviecomponent';

describe('Moviecomponent', () => {
  let component: Moviecomponent;
  let fixture: ComponentFixture<Moviecomponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Moviecomponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Moviecomponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
