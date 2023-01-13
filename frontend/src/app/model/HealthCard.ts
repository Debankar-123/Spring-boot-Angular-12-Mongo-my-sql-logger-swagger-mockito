import { Family } from './Family';

export class HealthCard {
  cardNo!: string;
  cardHolderName!: string;
  mobile!: number;
  email!: string;
  type!: string;
  limit!: number;
  validUpTo!: string;
  members!: number;
  familyMembers!: Family[];
}
